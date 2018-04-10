import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {SERVER_API_URL} from '../../app.constants';

import {JhiDateUtils} from 'ng-jhipster';

import {Employee} from './employee.model';
import {createRequestOption} from '../../shared';

export type EntityResponseType = HttpResponse<Employee>;

@Injectable()
export class EmployeeService {

    private resourceUrl = SERVER_API_URL + 'api/employees';

    constructor(private http: HttpClient, private dateUtils: JhiDateUtils) {
    }

    query(req?: any): Observable<HttpResponse<Employee[]>> {
        const options = createRequestOption(req);
        return this.http.get<Employee[]>(this.resourceUrl, {params: options, observe: 'response'})
            .map((res: HttpResponse<Employee[]>) => this.convertArrayResponse(res));
    }

    private convertArrayResponse(res: HttpResponse<Employee[]>): HttpResponse<Employee[]> {
        const jsonResponse: Employee[] = res.body;
        const body: Employee[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    private convertItemFromServer(employee: Employee): Employee {
        const copy: Employee = Object.assign({}, employee);
        copy.hireDate = this.dateUtils
            .convertLocalDateFromServer(employee.hireDate);
        return copy;
    }
}
