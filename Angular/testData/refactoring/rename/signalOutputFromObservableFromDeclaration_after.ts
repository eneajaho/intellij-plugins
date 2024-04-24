import {Component} from '@angular/core';
import {outputFromObservable} from "@angular/core/rxjs-interop";
import {Observable} from "rxjs";

@Component({
  selector: 'app-root',
  standalone: true,
  template: `
    <app-root (newOutput)="12"/>
  `,
  styleUrl: './app.component.css'
})
export class AppComponent {
  output$ = new Observable<string>()
  newOut<caret>put = outputFromObservable(this.output$)
}
