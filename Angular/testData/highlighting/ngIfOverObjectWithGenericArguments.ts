
import {Input, Component} from '@angular/core';
import {FormControl} from '@angular/forms'
import {NgIf} from "@angular/common";

@Component({
   selector: 'app-test',
   template: ``,
   standalone: true
 })
export class TestComponent {
  @Input() public testInput1!: string
  @Input() public testInput2!: number
}

@Component({
 selector: 'app-root',
 standalone: true,
 template: `
    <div>
      <ng-container *ngIf="selectedData.value">
        <div>
          <app-test
            [testInput1]="selectedData.value"
            [testInput2]="<error descr="Type string is not assignable to type number">selectedData.value</error>">
          </app-test>
        </div>
      </ng-container>
    </div>
  `,
 imports: [
   TestComponent,
   NgIf
 ]
})
export class AppComponent2 {
  protected selectedData = new FormControl<string | undefined>(undefined)
}
