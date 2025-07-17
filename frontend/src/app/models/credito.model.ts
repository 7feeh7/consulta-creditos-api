export interface Credito {
    id?: number;
    numeroCredito: string;
    numeroNfse: string;
    dataConstituicao: Date;
    valorIssqn: number;
    tipoCredito: string;
    simplesNacional: boolean;
    aliquota: number;
    valorFaturado: number;
    valorDeducao: number;
    baseCalculo: number;
}