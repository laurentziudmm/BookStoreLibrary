import { NgModule } from '@angular/core';

import {MatToolbarModule} from '@angular/material/toolbar';
import {MatListModule} from '@angular/material/list';
import {MatRadioModule} from '@angular/material/radio';
import {MatInputModule} from '@angular/material/input';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {MatIconModule} from '@angular/material/icon';
import {MatNativeDateModule} from '@angular/material/core';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatTabsModule} from '@angular/material/tabs';

@NgModule({
imports: [MatNativeDateModule,
          MatDatepickerModule,
          MatIconModule,
          MatButtonModule,
          MatCheckboxModule,
          MatToolbarModule,
          FormsModule,
          MatCardModule,
          MatFormFieldModule,
          MatInputModule,
          MatListModule,
          MatRadioModule,
          ReactiveFormsModule,
          MatSidenavModule,
          MatTabsModule
        ],
exports: [MatNativeDateModule,
          FormsModule,
          MatDatepickerModule,
          MatIconModule,
          MatButtonModule,
          MatCheckboxModule,
          MatToolbarModule,
          MatCardModule,
          MatFormFieldModule,
          MatInputModule,
          MatListModule,
          MatRadioModule,
          ReactiveFormsModule,
          MatSidenavModule,
          MatTabsModule
        ],
})

export class MyMaterialModule { }

