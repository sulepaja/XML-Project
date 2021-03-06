import { Component, OnInit } from '@angular/core';
import { RezervacijeService } from '../../services/rezervacije.service';
import { Rezervacija } from '../../model/Rezervacija';
import { Router } from '@angular/router';

import { Smestaj } from '../../model/Smestaj';
import { Soba } from '../../model/Soba';
import { AuthServiceService } from '../../services/auth-service.service';


@Component({
  selector: 'app-home-rezervacije',
  templateUrl: './home-rezervacije.component.html',
  styleUrls: ['./home-rezervacije.component.css']
})
export class HomeRezervacijeComponent implements OnInit {
  visible: boolean;
  rezervacije: Rezervacija[];
  rezervacijeAktivne: Rezervacija[];
  rezervacijeProsle: Rezervacija[];
  retVal: any;
  tempRez: Rezervacija;
  smestaji: Smestaj[];
  sobe: Soba[];
  user: any | null;

  private agent : any;

  constructor(private rezervacijeService: RezervacijeService, private authService: AuthServiceService, private router: Router) { }

  ngOnInit() {    
    this.getRezervacije();
    this.retVal = [];
    this.user = this.authService.getUser();
  }

  getRezervacije() {
    this.rezervacijeService.getRezervacije()
    .subscribe(rezervacije => this.rezervacije = rezervacije);
  }

  getUserReservation() {
    this.rezervacijeService.getUserReservationActive(this.user.id).subscribe(
      (data: Rezervacija[]) => {
        this.visible=true;
        this.rezervacijeAktivne = data;   
        this.smestaji = new Array(data.length);
        this.sobe = new Array(data.length);     
        console.log("Smestaj length: "+this.smestaji.length);
        var i:number;
        for(i = 0; i < data.length; i++) {
          this.getSmestajByRoomID(data[i].idSobe, i);
          this.getSobaInfo(data[i].idSobe,i);
        }
      }
   )
   //this.rezervacijeService.getUserReservationActive(this.user.id).subscribe(data =>{
     // this.rezervacijeAktivne = data;
   //});

  }

  getUserReservationPassed(){
    this.rezervacijeService.getUserReservationPassed(this.user.id).subscribe(
      (data: Rezervacija[]) => {
        this.visible=false;
        this.rezervacijeAktivne = data;   
        this.smestaji = new Array(data.length);
        this.sobe = new Array(data.length);     
        console.log("Smestaj length: "+this.smestaji.length);
        var i:number;
        for(i = 0; i < data.length; i++) {
          this.getSmestajByRoomID(data[i].idSobe, i);
          this.getSobaInfo(data[i].idSobe,i);
        }
      }
   )

  }

  getSmestajByRoomID(roomID: String, i: number) {
    this.rezervacijeService.getSmestajByRoomID(roomID).subscribe(
      (smestaj:Smestaj) => {
        console.log(smestaj.naziv);
        this.smestaji[i] = smestaj;
      }
    )
    
  }

  getSobaInfo(roomID: String, i:number) {
    this.rezervacijeService.getRoomByID(roomID).subscribe(
      (soba: Soba) => {
        console.log(soba);
        this.sobe[i] = soba
      }
    )
    
  }

  createRcensia(idSmestaja: string){
    localStorage.setItem('recenzijaSmestaj', idSmestaja);
    this.router.navigate(['/create-recenzija']);
  }


  cancelReservation(rezervacija : any) {
   
    this.rezervacijeService.deleteReservation(rezervacija.id)
    .subscribe(data => {
      
      this.retVal = data
      alert("You have successfully canceled your reservation.");  

      } 
    );


  }

  contact(smestaj : any) {
    this.rezervacijeService.getUserById(smestaj.idAgenta)
    .subscribe(data => {
      
      this.agent = data;
 
      this.rezervacijeService.selectAgent(this.agent);

      this.rezervacijeService.currentAgent.subscribe(
        currentAgent => 
        {
        console.log("Current agent from rezervacije: " +  currentAgent);
        }
      );

      this.router.navigateByUrl('/send-message');
      
      } 
    );
  }

}
