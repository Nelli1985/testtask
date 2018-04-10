import { BaseEntity } from './../../shared';

export const enum EmployeeType {
    'ASSOCIATE',
    'EXECUTIVE'
}

export class Employee implements BaseEntity {
    constructor(
        public id?: number,
        public employeeName?: string,
        public hireDate?: any,
        public type?: EmployeeType,
        public position?: string,
    ) {
    }
}
