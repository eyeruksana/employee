import { Component, OnInit } from '@angular/core';
import { EmpService } from '../employee/EmpService';
import { IEmployee } from '../employee/employee';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  employees:IEmployee[];

  constructor(private service:EmpService) { }

  ngOnInit(): void {
  }

  getEmployeeData(){
    this.service.getEmployees().subscribe(empData => {this.employees=empData; console.log("data:" +this.employees)});

  }


}
