import {NgModule, CUSTOM_ELEMENTS_SCHEMA} from '@angular/core';
import {RouterModule} from '@angular/router';

import {GovernmentSystemSharedModule} from '../../shared';
import {
    executiveEmployeeRoute,
} from './';
import {ExecutiveEmployeeService} from './executive-employee.service';
import {ExecutiveEmployeeDetailComponent} from './executive-employee-detail.component';
import {ExecutiveDetailResolver} from './executive-employee.route';

const ENTITY_STATES = [
    ...executiveEmployeeRoute,
];

@NgModule({
    imports: [
        GovernmentSystemSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        ExecutiveEmployeeDetailComponent,
    ],
    entryComponents: [],
    providers: [
        ExecutiveEmployeeService,
        ExecutiveDetailResolver,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GovernmentSystemExecutiveEmployeeModule {
}
