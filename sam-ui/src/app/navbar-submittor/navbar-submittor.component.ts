import { Component } from '@angular/core';
import {MenuItem} from 'primeng/api';
@Component({
  selector: 'app-navbar-submittor',
  templateUrl: './navbar-submittor.component.html',
  styleUrls: ['./navbar-submittor.component.css']
})
export class NavbarSubmittorComponent {

  items!: MenuItem[];


  ngOnInit() {

    this.items =[ {
      label: 'Logout',
      icon: 'pi pi-fw pi-user',

    }]
  }





}