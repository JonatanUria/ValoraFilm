import styles from './FilmCard.module.css'

type filmCards = {
  idPelicula: number
  title: string
  genre: string
  averageUserScore: number
  averageCriticsScore: number
  
}

export default function FilmCard({ idPelicula, title, genre, averageUserScore, averageCriticsScore }: filmCards) {
  return (

    <div className={styles.FilmCard}>
      <h1 className={styles.title}><b>{title}</b></h1>
      <p>Género: {genre}</p>
      <p>⭐ Usuarios: {averageUserScore}</p>
      <p>🎬 Críticos: {averageCriticsScore}</p>
    </div>
  );
}
