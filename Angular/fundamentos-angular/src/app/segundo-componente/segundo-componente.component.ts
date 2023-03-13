import { Component } from '@angular/core';

@Component({
  selector: 'app-segundo-componente',
  templateUrl: './segundo-componente.component.html',
  styleUrls: ['./segundo-componente.component.css']
})
export class SegundoComponenteComponent {

  nome = "João";
  dataNascimento = "1995-01-01";
  urlImagen = "/assets/IMG_2926.jpg"

  mostrarDataNascimento() {
    alert(`A data de nascimento é: ${this.dataNascimento}`)
  }
}
