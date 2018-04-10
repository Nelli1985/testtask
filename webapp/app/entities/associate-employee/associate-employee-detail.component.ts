import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Subscription} from 'rxjs/Subscription';

import {Big} from 'big.js';
import {AssociateEmployee, EmployeeSalary} from './associate-employee.model';
import {AssociateEmployeeService} from './associate-employee.service';

@Component({
    selector: 'jhi-associate-employee-detail',
    templateUrl: './associate-employee-detail.component.html'
})
export class AssociateEmployeeDetailComponent implements OnInit, OnDestroy {

    employee: AssociateEmployee;
    salaries: EmployeeSalary[];
    private subscription: Subscription;

    constructor(private associateEmployeeService: AssociateEmployeeService,
                private route: ActivatedRoute) {
    }

    ngOnInit() {
        this.subscription = this.route.data
            .subscribe((data: {
                employee: AssociateEmployee, salaries: EmployeeSalary[]
            }) => {
                this.employee = data.employee;
                this.salaries = data.salaries;
                if (this.salaries) {
                    this.salaries.sort((a, b) => a.assignDate - b.assignDate);
                }
            });
    }

    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
    }

    getTotal() {
        return this.salaries.map((s) => new Big(s.salary)).reduce((total, curr) => total.plus(curr)).toFixed(2);
    }

    getMin() {
        return this.salaries.map((s) => new Big(s.salary)).reduce((prev, curr) => prev.lt(curr) ? prev : curr).toFixed(2);
    }

    getAverage() {
        return new Big(this.getTotal()).div(this.salaries.length).toFixed(2);
    }
}
