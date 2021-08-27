import { Component, Inject, OnInit } from '@angular/core';
import { DOCUMENT } from '@angular/common';
import { UrlMappingService } from 'src/app/services/url-mapping.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-redirect',
  templateUrl: './redirect.component.html',
  styleUrls: ['./redirect.component.css']
})
export class RedirectComponent implements OnInit {

  private hashedUrl: string = "";
  redirectUrl: string | undefined;

  constructor(@Inject(DOCUMENT) private document: Document,
    private urlMappingService: UrlMappingService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.hashedUrl = String(this.route.snapshot.paramMap.get('hashedUrl'));

    console.log('Trying to fetch url for ' + this.hashedUrl);
    
    this.urlMappingService.getRedirectUrl(this.hashedUrl).subscribe(
      data => {
        console.log("redirect url: " + data);
        this.redirectUrl = data.redirectUrl;
      },
      error => {
        this.redirectUrl = "http://localhost:4200/err/404";
      }
    );
  }

  checkRedirect(redirectUrl: string | undefined) {
    if(redirectUrl) {
      this.document.location.href = redirectUrl;
    }
  }

}
