import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { GovernmentSystemSharedModule } from '../../shared';
import {
    EmployeeService,
    EmployeeComponent,
    employeeRoute,
    EmployeeResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...employeeRoute,
];

@NgModule({
    imports: [
        GovernmentSystemSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        EmployeeComponent,
    ],
    entryComponents: [
        EmployeeComponent,
    ],
    providers: [
        EmployeeService,
        EmployeeResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GovernmentSystemEmployeeModule {}
