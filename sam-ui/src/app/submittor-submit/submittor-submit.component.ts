import { Component,OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { SubmitterService } from '../submitter.service';
import { Paper } from '../paper';
import { Observable, Subject } from 'rxjs';
@Component({
  selector: 'app-submittor-submit',
  templateUrl: './submittor-submit.component.html',
  styleUrls: ['./submittor-submit.component.css']
})
export class SubmittorSubmitComponent {
  shortLink: string = "";
  loading: boolean = false; // Flag variable
  file: any; // Variable to store file
  uploadedFiles: any[] = [];
fileName=""
  name: string = "";
  p!: Paper;
  constructor(private submitterService: SubmitterService,private router: Router){

  }
  ngOnInit(): void {
    

  }


onFileSelected(event: any) {

  const fileIN:File = event.target.files[0];

  if (fileIN) {

          this.fileName = fileIN.name;

          this.file= fileIN
          console.log(this.file.name);

  }

}

  uploadPaper(name:string):void {
    this.submitterService.getPapers(11)
    .subscribe((paper) => this.p = paper);
    this.p.name = name
    this.submitterService.updatePaper(this.p).subscribe((paper) => this.p = paper);
    this.loading = !this.loading;
    console.log(this.file);
    this.submitterService.uploadPapers(11,this.file)
    .subscribe((event: any) => {
      if (typeof (event) === 'object') {

          // Short link via api response
          this.shortLink = event.link;

          this.loading = false; // Flag variable 
      }
  });
  }

}
