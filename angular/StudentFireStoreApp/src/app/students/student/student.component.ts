import { Component, OnInit } from '@angular/core';
import { StudentService } from 'src/app/shared/student.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  constructor(private service : StudentService) { }

  ngOnInit() {
    this.resetForm();
  }

  resetForm(form? : NgForm) {
    if (form != null) {
      form.resetForm();
    }
    this.service.formData = {
      id : null,
      studentId : "",
      fullName : "",
      dept : "",
      mobile : ""
    }
  }

}
