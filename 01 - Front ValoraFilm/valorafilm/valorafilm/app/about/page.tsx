import styles from './About.module.css'

export default function About() {
  return (
    <div className="flex min-h-screen flex-col  bg-zinc-50 font-sans dark:bg-black">
      <p className={styles.p}>
        ValoraFilm es un proyecto realizado por Jonatan Uría Lozoya como solución
        a la necesidad de dar de alta y puntuar las películas que el usuario haya
        visto últimamente.
        Para ello es necesario registrarse o iniciar sesión.</p>
    </div>

  );
}