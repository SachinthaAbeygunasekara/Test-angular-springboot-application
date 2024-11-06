import {Component, OnInit} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {Employee} from './entity/employee';
import {EmployeeService} from './service/employee.service';
import {HttpErrorResponse} from '@angular/common/http';
import {NgForOf} from '@angular/common';
import {MatSnackBar} from '@angular/material/snack-bar';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, NgForOf],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{

  public employees?: Employee[];

  ngOnInit(): void {
    this.getEmployees();
  }

  constructor(private employeeService: EmployeeService, private snackBar: MatSnackBar) {
  }

  public getEmployees(): void{
    this.employeeService.getEmployees().subscribe(
      (response: Employee[]) => {
        this.employees = response;
      },
      (error: HttpErrorResponse) => {
        //alert(error.message);
        this.snackBar.open(error.message, 'Close', { duration: 3000 });
      }
    );
  }
}
