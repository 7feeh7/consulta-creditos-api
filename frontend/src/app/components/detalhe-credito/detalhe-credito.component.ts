import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { CreditoService } from '../../services/credito.service';
import { Credito } from '../../models/credito.model';
import { CommonModule, Location } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@Component({
    selector: 'app-detalhe-credito',
    standalone: true,
    templateUrl: './detalhe-credito.component.html',
    styleUrls: ['./detalhe-credito.component.scss'],
    imports: [
        CommonModule,
        ReactiveFormsModule,
        FormsModule,
        RouterModule,
        HttpClientModule
    ]
})
export class DetalheCreditoComponent implements OnInit {
    credito: Credito | null = null;
    isLoading = false;
    errorMessage: string | null = null;


    constructor(
        private route: ActivatedRoute,
        private creditoService: CreditoService,
        private location: Location
    ) { }

    ngOnInit(): void {
        const numeroCredito = this.route.snapshot.paramMap.get('numeroCredito');
        if (numeroCredito) {
            this.carregarCredito(numeroCredito);
        }
    }

    carregarCredito(numeroCredito: string): void {
        this.isLoading = true;
        this.errorMessage = null;

        this.creditoService.getCreditoPorNumero(numeroCredito).subscribe({
            next: (credito) => {
                this.credito = credito;
                this.isLoading = false;
            },
            error: (err) => {
                this.errorMessage = 'Erro ao carregar crédito: ' + (err.error?.message || err.message);
                this.isLoading = false;
                setTimeout(() => this.errorMessage = null, 5000);
            }
        });
    }

    voltar(): void {
        this.location.back();
    }
}