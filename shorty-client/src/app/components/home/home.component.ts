import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';
import { UrlMappingService } from 'src/app/services/url-mapping.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

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
