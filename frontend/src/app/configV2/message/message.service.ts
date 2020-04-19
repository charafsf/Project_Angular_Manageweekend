import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Message } from './message.model';

@Injectable({
    providedIn: 'root',
})
export class MessageService {

    constructor(private http: HttpClient, private router: Router) { }

    connecte(message: Message) {

    }
}