import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {SERVER_API_URL} from '../../app.constants';

import {JhiDateUtils} from 'ng-jhipster';

import {ExecutiveEmployee, EmployeeBonus} from './executive-employee.model';

export type EntityResponseType = HttpResponse<ExecutiveEmployee>;

@Injectable()
export class ExecutiveEmployeeService {

    private resourceUrl = SERVER_API_URL + 'api/executive-employees';

    constructor(private http: HttpClient, private dateUtils: JhiDateUtils) {
    }

    find(id: any): Observable<EntityResponseType> {
        return this.http.get<ExecutiveEmployee>(`${this.resourceUrl}/${id}`, {observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    findBonusesForEmployee(id: any): Observable<HttpResponse<EmployeeBonus[]>> {
        return this.http.get<EmployeeBonus[]>(`${this.resourceUrl}/${id}/bonuses`, {observe: 'response'})
            .map((res: HttpResponse<EmployeeBonus[]>) => {
                const jsonResponse: EmployeeBonus[] = res.body;
                const body = jsonResponse.map((bonus) => {
                    bonus.bonusDate = this.dateUtils.convertLocalDateFromServer(bonus.bonusDate);
                    return bonus;
                });
                return res.clone({body});
            });
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: ExecutiveEmployee = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertItemFromServer(employee: ExecutiveEmployee): ExecutiveEmployee {
        const copy: ExecutiveEmployee = Object.assign({}, employee);
        copy.hireDate = this.dateUtils.convertLocalDateFromServer(employee.hireDate);
        return copy;
    }
}
