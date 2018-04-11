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
    bonuses: EmployeeBonus[];
    private subscription: Subscription;

    constructor(private executiveEmployeeService: ExecutiveEmployeeService,
                private route: ActivatedRoute) {
    }

    ngOnInit() {
        this.subscription = this.route.data
            .subscribe((data: {
                employee: ExecutiveEmployee, bonuses: EmployeeBonus[]
            }) => {
                this.employee = data.employee;
                this.bonuses = data.bonuses;
                if (this.bonuses) {
                    this.bonuses.sort((a, b) => a.bonusDate - b.bonusDate);
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
        return this.bonuses.map((s) => new Big(s.bonus)).reduce((total, curr) => total.plus(curr)).toFixed(2);
    }

    getMin() {
        return this.bonuses.map((s) => new Big(s.bonus)).reduce((prev, curr) => prev.lt(curr) ? prev : curr).toFixed(2);
    }

    getAverage() {
        return new Big(this.getTotal()).div(this.bonuses.length).toFixed(2);
    }
}
