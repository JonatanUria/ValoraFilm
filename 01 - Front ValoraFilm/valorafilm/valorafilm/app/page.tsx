"use client";

import styles from "./Home.module.css";
import { useAuth } from "../components/context/AuthProvider";
import { useEffect, useState } from "react";
import { apiFetch } from "@/lib/api";

import FilmCard from "@/components/ui/FilmCard";

export default function Home() {
  const { logged, loading } = useAuth();

  type Film = {
    idPelicula: number;
    titulo: string;
    genero: string;
    fechasEstreno: Date;
    paisOrigen: string;
    duracion: number;
    edadMinima: number;
    valoracionMediaUsuario: number;
    valoracionMediaCriticos: number
  };

  type AuthContextType = {
    film: Film;
  }

  // Primer paso defines las variables de peliculas (Es una lista de pelicuals)
  const [movies, setMovies] = useState<Film[]>([]);

  // Llamas al endpoint de listar peliculas

  useEffect(() => {
    async function loadFilms() {
      try {
        const res = await apiFetch("obtainfilms", {
          cache: "no-store",
        });

        if (!res.ok) {
          return;
        }

        const data = await res.json().catch(() => null);

        if (!!data) {
          // Seteas los datos de las peliculas...


          // Hacer la consulta al back...
          const res = await apiFetch("obtainfilms", {
            method: "GET",
          });
          const data = await res.json();

          const films = data.map((film: Film) => ({
            idPelicula: film.idPelicula,
            titulo: film.titulo,
            genero: film.genero,
            fechasEstreno: film.fechasEstreno,
            paisOrigen: film.paisOrigen,
            duracion: film.duracion,
            edadMinima: film.edadMinima,
            valoracionMediaUsuario: film.valoracionMediaUsuario,
            valoracionMediaCriticos: film.valoracionMediaCriticos
          }));


          setMovies(films);



          console.log(data);
        } else {
          console.log("No hay peliculas")
        }

      } catch {
        console.log("No hay peliculas")
      }
    }

    loadFilms();
  }, []);


  if (loading) {
    return <p>Cargando...</p>;
  }

  if (!logged) {
    return (
      <div className="flex min-h-screen flex-col items-center justify-center bg-zinc-50 dark:bg-black">
        <h1 className={styles.h1}>Bienvenido a ValoraFilm</h1>
        <h2 className={styles.h2}>
          Es necesario iniciar sesión o registrarse para continuar
        </h2>
      </div>
    );
  }

  console.log("Usuario logueado");


  return (
    <div className="flex min-h-screen flex-col items-center justify-center bg-green-50 dark:bg-black p-[25px]">
      <h1 className={styles.h1}>Todas las Películas</h1>
      <div className={styles.container_movies}>

        {
          movies.map((film, index) => (
            <FilmCard
              key={index}
              idPelicula = {film.idPelicula}
              title={film.titulo}
              genre={film.genero}
              averageUserScore={film.valoracionMediaUsuario}
              averageCriticsScore={film.valoracionMediaCriticos}
            />
          ))
        }
      </div>
    </div>
  );
}