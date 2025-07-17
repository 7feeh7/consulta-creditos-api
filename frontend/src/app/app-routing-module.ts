import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConsultaCreditosComponent } from './components/consulta-creditos/consulta-creditos.component';
import { DetalheCreditoComponent } from './components/detalhe-credito/detalhe-credito.component';

const routes: Routes = [
  { path: '', redirectTo: '/consulta', pathMatch: 'full' },
  { path: 'consulta', component: ConsultaCreditosComponent },
  { path: 'credito/:numeroCredito', component: DetalheCreditoComponent },
  { path: '**', redirectTo: '/consulta' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
