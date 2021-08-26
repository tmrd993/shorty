import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UrlMapping } from '../model/url-mapping';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UrlMappingService {

  private baseUrl = "http://localhost:8089/api"

  constructor(private httpClient: HttpClient) { }

  saveUrl(url: string): Observable<UrlMapping> {
    const saveUrl = `${this.baseUrl}/hashAndSave`;

    return this.httpClient.post<UrlMapping>(saveUrl, {originalUrl: `${url}`});
  }

  getRedirectUrl(hashedValue: string): Observable<string | undefined> {
    const redirectUrlRequestUrl = `${this.baseUrl}/${hashedValue}`;

    return this.httpClient.get<UrlMapping>(redirectUrlRequestUrl).pipe(
      map(response => response.originalUrl)
    );
  }
}
