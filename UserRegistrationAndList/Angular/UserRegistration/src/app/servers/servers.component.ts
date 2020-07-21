import { Component, OnInit } from '@angular/core';

@Component({

  selector: 'app-servers',
  templateUrl: './servers.component.html' ,
  styleUrls: ['./servers.component.css']
})
export class ServersComponent implements OnInit {

  allowNewServer = false;
  serverCreationStatus = 'No Server was Created';
  serverName = 'SEAS';

  constructor() {
    setTimeout(() => {
      this.allowNewServer = true;
    }   , 5000);
  }

  ngOnInit(): void {
  }

  onCreateServer(){
    this.serverCreationStatus = 'Server ' + this.serverName +  ' Created';
  }

  updateServerName(event: Event){
    console.log(event);
    this.serverName = ( event.target as HTMLInputElement ).value;
  }

}
