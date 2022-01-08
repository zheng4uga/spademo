import { Component,Input,OnInit } from '@angular/core';
import { CartItem } from './cartitem';

@Component({
      selector: 'app-checkout',
      styleUrls: ['./checkout.component.css'],
      templateUrl: './checkout.component.html'
})
export class CheckoutComponent implements OnInit{

    @Input() title:string;
    @Input() summary:string;
    @Input() helptext:string;
    cartItems : CartItem[] = [
        {
            image:'https://www.eaton.com/content/dam/eaton/company/brightlayer/solar-panel-extreme-closeup-110883539.jpg.transform/default-mobile/image.jpg',
            title:'Test Item',
            developer: 'Eaton',
            category: '12345',
            unitPrice: 100,
            price:100
        }
    ]

    constructor() {}

    ngOnInit(): void {
    }

}