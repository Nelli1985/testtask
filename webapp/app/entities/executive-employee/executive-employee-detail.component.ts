import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Subscription} from 'rxjs/Subscription';

import {Big} from 'big.js';
import {ExecutiveEmployee, EmployeeBonus} from './executive-employee.model';
import {ExecutiveEmployeeService} from './executive-employee.service';

@Component({
    selector: 'jhi-executive-employee-detail',
    templateUrl: './executive-employee-detail.component.html'
})
export class ExecutiveEmployeeDetailComponent implements OnInit, OnDestroy {

    employee: ExecutiveEmployee;
    private subscription: Subscription;

    constructor(private executiveEmployeeService: ExecutiveEmployeeService,
                private route: ActivatedRoute) {
    }

    ngOnInit() {
        this.subscription = this.route.data
            .subscribe((data: {
                employee: ExecutiveEmployee
            }) => {
                this.employee = data.employee;
            });
    }

    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
    }
}
