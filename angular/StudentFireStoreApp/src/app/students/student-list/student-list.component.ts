import { Component, OnInit } from '@angular/core';
import { StudentService } from 'src/app/shared/student.service';
import { Student } from 'src/app/shared/student.model';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  list : Student[];
  constructor(private service : StudentService) { }

  ngOnInit() {
    this.service.getStudents().subscribe(actionArray => {
      this.list = actionArray.map(item => {
        return {
          id : item.payload.doc.id,
          ...item.payload.doc.data()
        } as Student
      })
    });
  }

}
