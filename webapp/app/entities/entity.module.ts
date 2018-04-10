import {NgModule, CUSTOM_ELEMENTS_SCHEMA} from '@angular/core';

import {GovernmentSystemEmployeeModule} from './employee/employee.module';
import {GovernmentSystemExecutiveEmployeeModule} from './executive-employee/executive-employee.module';
import {GovernmentSystemAssociateEmployeeModule} from './associate-employee/associate-employee.module';

/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        GovernmentSystemEmployeeModule,
        GovernmentSystemExecutiveEmployeeModule,
        GovernmentSystemAssociateEmployeeModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GovernmentSystemEntityModule {
}
