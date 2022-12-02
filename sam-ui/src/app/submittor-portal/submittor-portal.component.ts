import { Component } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { SubmitterService } from '../submitter.service';
import { Paper } from '../paper';
import { getSafePropertyAccessString } from '@angular/compiler';
import {saveAs} from 'file-saver';

@Component({
  selector: 'app-submittor-portal',
  templateUrl: './submittor-portal.component.html',
  styleUrls: ['./submittor-portal.component.css']
})
export class SubmittorPortalComponent {

  paper: Paper[] = [];
  id!: number;
  file: any;

  constructor(private submitterService: SubmitterService, private router: Router) {

  }
  ngOnInit(): void {
    this.id = this.submitterService.getId()
    console.log(this.id)
    this.getPaper(this.id);
    // this.getPaperFiles(11);
  }
  getPaper(id: number): void {
    this.submitterService.getPapers(id)
      .subscribe((paper) => this.paper = paper);
  }
  getPaperFiles(id: number): void {
    this.submitterService.downloadPapers(id).subscribe((res) => {
      this.file = res
      console.log(this.file.name);
      console.log(this.file);
      saveAs(res, (this.paper[0].name+".pdf"));

    });
  }




}
