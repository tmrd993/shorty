import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { UrlMappingService } from './services/url-mapping.service';
import { FormsModule } from '@angular/forms';
import { RedirectComponent } from './components/redirect/redirect.component';
import { HomeComponent } from './components/home/home.component';
import { RouterModule, Routes } from '@angular/router';
import { ResourceNotFoundComponent } from './components/resource-not-found/resource-not-found.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: ':hashedUrl', component: RedirectComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: '**', component: ResourceNotFoundComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    RedirectComponent,
    HomeComponent,
    ResourceNotFoundComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    UrlMappingService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
