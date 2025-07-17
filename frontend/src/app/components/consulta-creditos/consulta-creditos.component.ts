import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';

import { Router, RouterModule } from '@angular/router';
import { Credito } from '../../models/credito.model';
import { CommonModule } from '@angular/common';
import { CreditoService } from '../../services/credito.service';
import { HttpClientModule } from '@angular/common/http';

@Component({
    selector: 'app-consulta-creditos',
    standalone: true,
    templateUrl: './consulta-creditos.component.html',
    styleUrls: ['./consulta-creditos.component.scss'],
    imports: [
        CommonModule,
        ReactiveFormsModule,
        FormsModule,
        RouterModule,
        HttpClientModule
    ]
})
export class ConsultaCreditosComponent implements OnInit {
    consultaForm: FormGroup;
    creditos: Credito[] = [];
    isLoading = false;
    errorMessage: string | null = null;
    successMessage: string | null = null;
    infoMessage: string | null = null;

    constructor(
        private fb: FormBuilder,
        private creditoService: CreditoService,
        private router: Router
    ) {
        this.consultaForm = this.fb.group({
            numeroNfse: ['', Validators.required],
            numeroCredito: ['']
        });
    }

    ngOnInit(): void {
        this.consultaForm.get('numeroCredito')?.valueChanges.subscribe(value => {
            if (value) {
                this.consultaForm.get('numeroNfse')?.clearValidators();
                this.consultaForm.get('numeroNfse')?.setErrors(null);
            } else {
                this.consultaForm.get('numeroNfse')?.setValidators([Validators.required]);
            }
            this.consultaForm.get('numeroNfse')?.updateValueAndValidity();
        });
    }

    consultar(): void {
        if (this.consultaForm.invalid) {
            this.errorMessage = 'Por favor, preencha pelo menos o número da NFS-e';
            setTimeout(() => this.errorMessage = null, 5000);
            return;
        }

        this.isLoading = true;
        this.creditos = [];
        this.errorMessage = null;
        this.successMessage = null;
        this.infoMessage = null;

        const numeroNfse = this.consultaForm.get('numeroNfse')?.value;
        const numeroCredito = this.consultaForm.get('numeroCredito')?.value;

        if (numeroCredito) {
            this.creditoService.getCreditoPorNumero(numeroCredito).subscribe({
                next: (credito) => {
                    this.creditos = [credito];
                    this.isLoading = false;
                    if (!credito) {
                        this.creditos = [];
                        this.infoMessage = 'Nenhum crédito encontrado para o número informado.';
                        setTimeout(() => this.infoMessage = null, 5000);
                    }
                },
                error: (err) => {
                    this.errorMessage = 'Erro ao buscar crédito: ' + (err.error?.message || err.message);
                    this.isLoading = false;
                    setTimeout(() => this.errorMessage = null, 5000);
                }
            });
        } else {
            this.creditoService.getCreditosPorNfse(numeroNfse).subscribe({
                next: (creditos) => {
                    this.creditos = creditos;
                    this.isLoading = false;
                    if (!creditos || creditos.length === 0) {
                        this.infoMessage = 'Nenhum crédito encontrado para a NFS-e informada.';
                        setTimeout(() => this.infoMessage = null, 5000);
                    }
                },
                error: (err) => {
                    this.errorMessage = 'Erro ao buscar créditos: ' + (err.error?.message || err.message);
                    this.isLoading = false;
                    setTimeout(() => this.errorMessage = null, 5000);
                }
            });
        }
    }

    verDetalhes(numeroCredito: string): void {
        this.router.navigate(['/credito', numeroCredito]);
    }

    get formControls() {
        return this.consultaForm.controls;
    }
}