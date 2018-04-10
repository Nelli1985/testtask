import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot, Routes} from '@angular/router';

import {UserRouteAccessService} from '../../shared';
import {AssociateEmployeeDetailComponent} from './associate-employee-detail.component';
import {Observable} from 'rxjs/Observable';
import {Injectable} from '@angular/core';
import {HttpResponse} from '@angular/common/http';
import {AssociateEmployee, EmployeeSalary} from './associate-employee.model';
import {AssociateEmployeeService} from './associate-employee.service';

@Injectable()
export class AssociateDetailResolver implements Resolve<AssociateEmployee> {
    constructor(private associateEmployeeService: AssociateEmployeeService) {
    }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<AssociateEmployee> {
        const id = route.params['id'];
        return this.associateEmployeeService.find(id)
            .map((employeeResponse: HttpResponse<AssociateEmployee>) => {
                return employeeResponse.body;
            });
    }
}

@Injectable()
export class EmployeeSalariesResolver implements Resolve<EmployeeSalary[]> {
    constructor(private associateEmployeeService: AssociateEmployeeService) {
    }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<EmployeeSalary[]> {
        const id = route.params['id'];
        return this.associateEmployeeService.findSalariesForEmployee(id)
            .map((employeeResponse: HttpResponse<EmployeeSalary[]>) => {
                return employeeResponse.body;
            });
    }
}

export const associateEmployeeRoute: Routes = [
    {
        path: 'associate-employee/:id',
        component: AssociateEmployeeDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Associate Employee'
        },
        canActivate: [UserRouteAccessService],
        resolve: {
            employee: AssociateDetailResolver,
            salaries: EmployeeSalariesResolver
        }
    }
];
