import { Component } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { SubmitterService } from '../submitter.service';
import { Paper } from '../paper';
import { getSafePropertyAccessString } from '@angular/compiler';
@Component({
  selector: 'app-submittor-portal',
  templateUrl: './submittor-portal.component.html',
  styleUrls: ['./submittor-portal.component.css']
})
export class SubmittorPortalComponent {

  paper: Paper[]=[];

  constructor(private submitterService: SubmitterService,private router: Router){

  }
  ngOnInit(): void {
    this.getPaper(11);

  }
  getPaper(id:number):void {

    this.submitterService.getPapers(id)
    .subscribe((paper) => this.paper = paper);
  }

}
