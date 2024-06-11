export type Songs = Song[]

export interface Song {
  id: number
  image: string
  style: string
  artist: string
  album: string
  name: string
  duration: string
  reproductions: number
  estrellas: number
}
