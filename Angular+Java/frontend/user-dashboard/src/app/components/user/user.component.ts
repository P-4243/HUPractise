import { CommonModule } from '@angular/common';
import { Component,OnInit } from '@angular/core';//OnInit-"Run this logic when component is initialized."
import { UserService } from '../../service/user.service'
import {User} from '../../models/user.model';//We will use this interface to define the type of users array. It will help us with type checking and code completion in our IDE.
import { ReactiveFormsModule,FormControl } from '@angular/forms';
import { debounceTime, throttleTime} from 'rxjs/operators';
import { Observable, Subject } from 'rxjs';
import { UserStoreService} from '../../store/user-store.service';

@Component({
  selector: 'app-user',
  standalone: true,
  imports: [CommonModule,ReactiveFormsModule],//we will use: *ngFor ....Angular directives live inside CommonModule.
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent implements OnInit{
 
  clickSubject=new Subject<void>();

constructor(
  private userService:UserService,
  private userStore:UserStoreService){
    this.clickSubject
    .pipe(throttleTime(2000))//throttleTime will allow only one click event to pass through every 2 seconds. If we click multiple times within 2 seconds, only the first click will be registered and the rest will be ignored.
    .subscribe(()=>{
      console.log("Button processed");
    });
  }

  throttleTest()
  {
    console.log("button clicked");
    this.clickSubject.next();
  }

rowClicked(user:User)
{
  console.log("row clicked:",user.name);
}

buttonClicked(user: User,event:Event)
{
  event.stopPropagation();//(Stop Bubbling)This will stop the click event from bubbling up to the row when we click the button. So only the button click logic will execute, not the row click logic.
  console.log("button clicked:",user.name);
}
searchControl=new FormControl('');  //This creates a new form control for the search input field. The initial value is an empty string.

//users:any[]=[];//This is just a TypeScript array.Equivalent in Java:...List<User> users = new ArrayList<>();
//users:User[]=[];//This is a TypeScript array of User objects.
//users$=this.userStore.users$;//We are assigning the users$ Observable from the store to a local variable in the component. Now we can use this users$ variable in our template to display the list of users. Whenever the data in the store changes, our component will automatically get the updated list of users through this Observable.  
users$!:Observable<User[]>;//The ! means:I promise this will be initialized later.

ngOnInit(): void {

  this.users$=this.userStore.users$;//We are assigning the users$ Observable from the store to a local variable in the component. Now we can use this users$ variable in our template to display the list of users. Whenever the data in the store changes, our component will automatically get the updated list of users through this Observable.  

  // Load all users initially
  this.userService.getUsers().subscribe((response)=>
    {//getUsers() returns Observable
  // this.searchControl.valueChanges.subscribe(value=>{
  //   console.log(value);
  // })
    //this.users=response;//response is the data we get from backend and we are assigning it to users array.
    this.userStore.setUsers(response);//We push the data into the store. Now any component that subscribes to users$ will get this data.  
    });

  this.searchControl.valueChanges
  .pipe(debounceTime(500))//.pipe() allows you to apply operators to an Observable stream.
  .subscribe(value=>{
    if(!value)
    {
      this.userService.getUsers()
      .subscribe(response=>{
        this.userStore.setUsers(response);//We push the data into the store. Now any component that subscribes to users$ will get this data.  
        //this.users=response;
      });
    }
    else
    {
      this.userService.searchUsers(value)
      .subscribe(response=>{
        this.userStore.setUsers(response);//We push the data into the store. Now any component that subscribes to users$ will get this data.  
        //this.users=response;
      })
    }
    console.log(value);
  });
}
}