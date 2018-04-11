import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot, Routes} from '@angular/router';
import {UserRouteAccessService} from '../../shared';
import {ExecutiveEmployeeDetailComponent} from './executive-employee-detail.component';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {ExecutiveEmployee, EmployeeBonus} from './executive-employee.model';
import {HttpResponse} from '@angular/common/http';
import {ExecutiveEmployeeService} from './executive-employee.service';

@Injectable()
export class ExecutiveDetailResolver implements Resolve<ExecutiveEmployee> {
    constructor(private executiveEmployeeService: ExecutiveEmployeeService) {
    }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<ExecutiveEmployee> {
        const id = route.params['id'];
        return this.executiveEmployeeService.find(id)
            .map((employeeResponse: HttpResponse<ExecutiveEmployee>) => {
                return employeeResponse.body;
            });
    }
}
@Injectable()
export class EmployeeBonusesResolver implements Resolve<EmployeeBonus[]> {
    constructor(private executiveEmployeeService: ExecutiveEmployeeService) {
    }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<EmployeeBonus[]> {
        const id = route.params['id'];
        return this.executiveEmployeeService.findBonusesForEmployee(id)
            .map((employeeResponse: HttpResponse<EmployeeBonus[]>) => {
                return employeeResponse.body;
            });
    }
}

export const executiveEmployeeRoute: Routes = [
    {
        path: 'executive-employee/:id',
        component: ExecutiveEmployeeDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Executive Employee'
        },
        canActivate: [UserRouteAccessService],
        resolve: {
            employee: ExecutiveDetailResolver,
            bonuses: EmployeeBonusesResolver
        }
    }
];
