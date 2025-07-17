import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'app-consulta-creditos',
    templateUrl: './consulta-creditos.component.html',
    styleUrls: ['./consulta-creditos.component.scss']
})
export class ConsultaCreditosComponent implements OnInit {
    constructor(
        private router: Router
    ) { }

    ngOnInit(): void {
    }

    consultar(): void { }

    verDetalhes(numeroCredito: string): void {
        this.router.navigate(['/credito', numeroCredito]);
    }
}