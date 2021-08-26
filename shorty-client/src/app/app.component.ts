import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';
import { UrlMappingService } from './services/url-mapping.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  hashedValue: string | undefined;

  userInputUrl: string = "";


  constructor(private urlMappingService: UrlMappingService) { }

  ngOnInit(): void {
    this.hashedValue = "";
  }

  saveUserInputUrl(): void {
    this.hashedValue = "";
    console.log("Trying to save: " + this.userInputUrl);

    this.urlMappingService.saveUrl(this.userInputUrl).pipe(first()).subscribe(
      data => this.hashedValue = data.hashedValue
    );
  }
  

}
