import { Geist, Geist_Mono } from "next/font/google";

import Header from "../components/layout/Header";
import Footer from "../components/layout/Footer";
import { apiFetch } from "@/lib/api";
import "../app/globals.css";
import { AuthProvider } from "../components/context/AuthProvider";

const geistSans = Geist({
  variable: "--font-geist-sans",
  subsets: ["latin"],
});

const geistMono = Geist_Mono({
  variable: "--font-geist-mono",
  subsets: ["latin"],
});



export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html lang="en">
      <body>
        <AuthProvider>
          <Header />
          {children}
          <Footer />
        </AuthProvider>
      </body>
    </html>
  );
}