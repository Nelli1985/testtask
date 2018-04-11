import {BaseEntity} from './../../shared';
import {Employee} from '../employee';

export class ExecutiveEmployee extends Employee {
    public email: string;
    public phoneNumber: string;
    public parkingSpaceCode: string;
}

export class EmployeeBonus implements BaseEntity {
    constructor(
        public id?: number,
        public bonusDate?: any,
        public bonus?: number,
    ) {
    }
}
