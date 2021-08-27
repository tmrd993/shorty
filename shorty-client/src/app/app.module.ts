import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import { AppComponent } from './app.component';
import { UrlMappingService } from './services/url-mapping.service';
import { FormsModule } from '@angular/forms';
import { RedirectComponent } from './components/redirect/redirect.component';
import { HomeComponent } from './components/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    RedirectComponent,
    HomeComponent
  ],
  imports: [
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
