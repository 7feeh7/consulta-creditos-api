import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

@Component({
    selector: 'app-detalhe-credito',
    templateUrl: './detalhe-credito.component.html',
    styleUrls: ['./detalhe-credito.component.scss']
})
export class DetalheCreditoComponent implements OnInit {
    isLoading = false;

    constructor(
        private route: ActivatedRoute,
        private location: Location
    ) { }

    ngOnInit(): void { }

    carregarCredito(numeroCredito: string): void { }

    voltar(): void {
        this.location.back();
    }
}