import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UrlMapping } from '../model/url-mapping';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UrlMappingService {

  private baseUrl = environment.backendServerBaseUrl;

  constructor(private httpClient: HttpClient) { }

  saveUrl(url: string): Observable<UrlMapping> {
    const saveUrl = `${this.baseUrl}/hashAndSave`;

    return this.httpClient.post<UrlMapping>(saveUrl, {originalUrl: `${url}`});
  }

  getRedirectUrl(hashedValue: string): Observable<UrlMapping> {
    const redirectUrlRequestUrl = `${this.baseUrl}/${hashedValue}`;

    return this.httpClient.get<UrlMapping>(redirectUrlRequestUrl);

    
  }
}
