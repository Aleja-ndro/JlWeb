import{Link} from 'react-router-dom';
import{FaBars,FaSearch, FaShoppingCart} from 'react-icons/fa';
import{categories} from '../data/categories';
import { useState } from 'react';

export default function Navbar(){
    const [isOpen,setIsOpen]= useState(false);
    return(
        <nav className='bg-blue-600 p-4 text-white shadow-md sticky top-0 z-50'>
            <div className='container mx-auto flex flex-col md:flex-row justify-between items-center'>
               <div className='flex items-center justify-between w-full md:w-auto'>
                <div className='flex items-center space-x-4'>
                <img src='./images/logoWD.png' className='w-12 h-12 md:w-20 rounded-full bg-white' alt='logo' ></img>
                
                <Link to="/" className='text-xl font-bold whitespace-nowrap'>Libreria Jl</Link>
                </div>
               <button
               className='md:hidden text-2x1'
               onClick={()=>setIsOpen(!isOpen)}
               >
                <FaBars/>
               </button>
                </div>

                <div className='w-full md:w-auto order-first md:order-none'>
                    <div className='relative max-w-x1 mx-auto md:mx-0'>
                        <input
                        type='text'
                        placeholder='Buscar productos...'
                        className='w-full py-2 px-4 pr-10 rounded-full text-gray-800
                        focus:outline-none focus:ring-2 focus:ring-blue-300'/>
                        <button className='absolute right-3 top-1/2 transform -translate-y-1/2 text-red-500'>
                        <FaSearch/>
                        </button>
                    </div>
                </div>
                
                <div className='hidden md:flex space-x-6 items-center'>
                    <Link to="/category/libreria" className='hover:underline whitespace-nowrap'>Libreria</Link>
                    <Link to="/category/cotillon" className='hover:underline whitespace-nowrap'>Cotillon </Link>
                    <Link to="/category/tecnologia" className='hover:underline whitespace-nowrap'>Tecnologia</Link>
                    <Link to="/category/juguetes" className='hover:underline whitespace-nowrap'>Juguetes</Link>
                    <Link to="/category/centro de copiado" className='hover:underline whitespace-nowrap'>Centro de copiado</Link>
                    <Link to="/category/varios" className='hover:underline whitespace-nowrap'>Varios</Link>
                    <Link to="/cart" className='flex items-center gap-1 hover:underline'>
                    <FaShoppingCart/>Carrito
                    </Link>
                </div>
                {isOpen && (
                    <div className='md:hidden w-full mt-4 space-y-4 flex flex-col items-center'>
                            <Link to="/category/libreria" className='hover:underline '>Libreria</Link>
                    <Link to="/category/cotillon" className='hover:underline '>Cotillon </Link>
                    <Link to="/category/tecnologia" className='hover:underline '>Tecnologia</Link>
                    <Link to="/category/juguetes" className='hover:underline '>Juguetes</Link>
                    <Link to="/category/centro de copiado" className='hover:underline '>Centro de copiado</Link>
                    <Link to="/category/varios" className='hover:underline '>Varios</Link>
                    <Link to="/cart" className='flex items-center gap-1 hover:underline'>
                    <FaShoppingCart/>Carrito
                    </Link>
                    </div>
                )}
            </div>
            </nav>
              );
}