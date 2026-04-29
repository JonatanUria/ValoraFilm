"use client";

import { createContext, useContext, useEffect, useState } from "react";
import { apiFetch } from "@/lib/api";


type userResponse = {
  idUsuario: number,
  email: string;
  fechaNacimiento: string;   // viene como ISO string desde backend
  fechaRegistro: string;     // ISO string
  fotoPerfil: string | null;
  genero: string | null;
  nombreUsuario: string;
  paisOrigen: string | null;
  tipoUsuario: string;
};

type AuthContextType = {
  logged: boolean;
  loading: boolean;
  userId: string;
  user: userResponse | null;
};

const AuthContext = createContext<AuthContextType>({
  logged: false,
  loading: true,
  userId: "0",
  user: null
});

export function AuthProvider({ children }: { children: React.ReactNode }) {
  const [logged, setLogged] = useState(false);
  const [loading, setLoading] = useState(true);
  const [userId, setUserId] = useState("0");
  // Para setear el usuario
  const [user, setUser] = useState<userResponse | null>(null);


  useEffect(() => {
    async function checkAuth() {
      try {
        const res = await apiFetch("auth/me", {
          credentials: "include",
          cache: "no-store",
        });

        if (!res.ok) {
          setLogged(false);
          return;
        }

        const data = await res.json().catch(() => null);

        console.log("Está logeado??????")
        if (!!data) {
          setLogged(true);
          setUserId(data);
          // Hacer la consulta al back...
          const res = await apiFetch("obtainanuser/" + data, {
            method: "GET",
          });
          const json = await res.json();

          const user: userResponse = {
            idUsuario: json.idUsuario,
            email: json.email,
            fechaNacimiento: json.fechaNacimiento,
            fechaRegistro: json.fechaRegistro,
            fotoPerfil: json.fotoPerfil,
            genero: json.genero,
            nombreUsuario: json.nombreUsuario,
            paisOrigen: json.paisOrigen,
            tipoUsuario: json.tipoUsuario,
          };

          setUser(user);

          console.log(json);
        } else {
          setLogged(false);
        }

      } catch {
        setLogged(false);
      } finally {
        setLoading(false);
      }
    }

    checkAuth();
  }, []);

  return (
    <AuthContext.Provider value={{ logged, loading, userId, user }}>
      {children}
    </AuthContext.Provider>
  );
}

export const useAuth = () => useContext(AuthContext);