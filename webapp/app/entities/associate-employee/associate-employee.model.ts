import {BaseEntity} from './../../shared';
import {Employee} from "../employee";

export class AssociateEmployee extends Employee {
    public favouriteTool: string;
    public coffeePreference: string;
}

export class EmployeeSalary implements BaseEntity {
    constructor(
        public id?: number,
        public assignDate?: any,
        public salary?: number,
    ) {
    }
}
