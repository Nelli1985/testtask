import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';

import {GovernmentSystemSharedModule} from '../../shared';
import {associateEmployeeRoute, AssociateDetailResolver, EmployeeSalariesResolver} from './associate-employee.route';
import {AssociateEmployeeService} from './associate-employee.service';
import {AssociateEmployeeDetailComponent} from './associate-employee-detail.component';

const ENTITY_STATES = [
    ...associateEmployeeRoute,
];

@NgModule({
    imports: [
        GovernmentSystemSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        AssociateEmployeeDetailComponent,
    ],
    entryComponents: [],
    providers: [
        AssociateEmployeeService,
        AssociateDetailResolver,
        EmployeeSalariesResolver
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GovernmentSystemAssociateEmployeeModule {
}
