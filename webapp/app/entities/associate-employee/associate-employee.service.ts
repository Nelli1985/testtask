import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {SERVER_API_URL} from '../../app.constants';

import {JhiDateUtils} from 'ng-jhipster';
import {AssociateEmployee, EmployeeSalary} from './associate-employee.model';

export type EntityResponseType = HttpResponse<AssociateEmployee>;

@Injectable()
export class AssociateEmployeeService {

    private resourceUrl = SERVER_API_URL + 'api/associate-employees';

    constructor(private http: HttpClient, private dateUtils: JhiDateUtils) {
    }

    find(id: any): Observable<EntityResponseType> {
        return this.http.get<AssociateEmployee>(`${this.resourceUrl}/${id}`, {observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    findSalariesForEmployee(id: any): Observable<HttpResponse<EmployeeSalary[]>> {
        return this.http.get<EmployeeSalary[]>(`${this.resourceUrl}/${id}/salaries`, {observe: 'response'})
            .map((res: HttpResponse<EmployeeSalary[]>) => {
                const jsonResponse: EmployeeSalary[] = res.body;
                const body = jsonResponse.map((salary) => {
                    salary.assignDate = this.dateUtils.convertLocalDateFromServer(salary.assignDate);
                    return salary;
                });
                return res.clone({body});
            });
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: AssociateEmployee = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertItemFromServer(employee: AssociateEmployee): AssociateEmployee {
        const copy: AssociateEmployee = Object.assign({}, employee);
        copy.hireDate = this.dateUtils.convertLocalDateFromServer(employee.hireDate);
        return copy;
    }
}
