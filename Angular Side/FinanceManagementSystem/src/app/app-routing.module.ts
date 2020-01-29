import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { MainComponent } from './main/main.component';
import { ProductInfoComponent } from './product-info/product-info.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { EmiPaymentComponent } from './emi-payment/emi-payment.component';


const routes: Routes = [
{path:'register',component:RegisterComponent},
{path:'login',component:LoginComponent},
{path:'main',component:MainComponent},
{path:'product-info', component:ProductInfoComponent},
{path:'dashboard', component:DashboardComponent},
{path:'emi-payment', component:EmiPaymentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 
  
}
