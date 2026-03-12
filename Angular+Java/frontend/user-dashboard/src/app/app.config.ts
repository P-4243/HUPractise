import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';//provideZoneChangeDetection?=Angular automatically updates UI when something changes.
import { provideRouter } from '@angular/router';//Router decides:=Which component to load for which URL.
import { routes } from './app.routes';

import { provideHttpClient } from '@angular/common/http';

export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({ eventCoalescing: true }),//“Optimize change detection by batching multiple events together.
    provideRouter(routes),
    provideHttpClient()]
};
// eventCoalescing: true
// Without coalescing:
// Angular may run change detection 3 times.
// With coalescing:
// Angular groups them and runs fewer detection cycles.